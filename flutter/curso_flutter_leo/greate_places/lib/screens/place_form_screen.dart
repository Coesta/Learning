import 'dart:io';

import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:greate_places/providers/great_places.dart';
import 'package:greate_places/widgets/image_input.dart';
import 'package:greate_places/widgets/location_input.dart';
import 'package:provider/provider.dart';

class PlaceFormScree extends StatefulWidget {
  @override
  _PlaceFormScreeState createState() => _PlaceFormScreeState();
}

class _PlaceFormScreeState extends State<PlaceFormScree> {
  final _titleController = TextEditingController();
  File _pickedImage;
  LatLng _pickedPosition;

  void _selectImage(File pickedImage) {
    setState(() {
      _pickedImage = pickedImage;
    });
  }

  void _selectPosition(LatLng position) {
    setState(() {
      _pickedPosition = position;
    });
  }

  bool _isValidForm() {
    return _titleController.text.isNotEmpty &&
        _pickedImage != null &&
        _pickedPosition != null;
  }

  void _submitForm() {
    if (!_isValidForm()) return;

    Provider.of<GreatPlaces>(context, listen: false).addPlaces(
      _titleController.text,
      _pickedImage,
      _pickedPosition,
    );

    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Novo Lugar'),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          Expanded(
            child: SingleChildScrollView(
              child: Padding(
                padding: const EdgeInsets.all(10.0),
                child: Column(
                  children: [
                    TextField(
                      controller: _titleController,
                      decoration: InputDecoration(
                        labelText: 'Título',
                      ),
                    ),
                    SizedBox(height: 10),
                    ImageInput(this._selectImage),
                    SizedBox(height: 10),
                    LocationInput(this._selectPosition),
                  ],
                ),
              ),
            ),
          ),
          RaisedButton.icon(
            icon: Icon(Icons.add),
            label: Text('Adicionar'),
            color: Theme.of(context).accentColor,
            elevation: 0,
            materialTapTargetSize: MaterialTapTargetSize.shrinkWrap,
            onPressed: _isValidForm() ? _submitForm : null,
          ),
        ],
      ),
    );
  }
}
