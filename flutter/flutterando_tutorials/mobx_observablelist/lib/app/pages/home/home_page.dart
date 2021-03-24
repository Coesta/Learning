import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';
import 'package:mobx_observablelist/app/models/item_model.dart';
import 'package:mobx_observablelist/app/pages/home/components/item_widget.dart';
import 'package:mobx_observablelist/app/pages/home/home_controller.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final controller = HomeController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: TextField(
          onChanged: controller.setFilter,
          decoration: InputDecoration(hintText: 'Pesquisa...'),
        ),
        actions: [
          IconButton(
            icon: Observer(
              builder: (_) => Text('${controller.totalChecked}'),
            ),
            onPressed: () {},
          )
        ],
      ),
      body: Observer(
        builder: (_) {
          if (controller.output.data == null)
            return Center(
              child: CircularProgressIndicator(),
            );
          return ListView.builder(
            // itemCount: controller.listFiltered.length,
            itemCount: controller.output.data.length,
            itemBuilder: (context, index) {
              // var item = controller.listFiltered[index];
              var item = controller.output.data[index];
              return ItemWidget(
                item: item,
                onRemove: () => controller.removeItem(item),
              );
            },
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () => _dialog(),
      ),
    );
  }

  _dialog() {
    var model = ItemModel();

    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Text('Adicionar item'),
        content: TextField(
          onChanged: model.setTitle,
          decoration: InputDecoration(
            border: OutlineInputBorder(),
            labelText: 'Novo item',
          ),
        ),
        actions: <Widget>[
          FlatButton(
            onPressed: () {
              controller.addItem(model);
              Navigator.pop(context);
            },
            child: Text('Salvar'),
          ),
          FlatButton(
            onPressed: () => Navigator.pop(context),
            child: Text('Cancelar'),
          )
        ],
      ),
    );
  }
}
