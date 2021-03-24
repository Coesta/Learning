import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';
import 'package:mobx_cart_list/controller.dart';

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final controller = Controller();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Formulário'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Observer(
              builder: (_) => _textField(
                labelText: 'name',
                onChange: controller.client.changeName,
                errorText: controller.validateName,
              ),
            ),
            SizedBox(height: 20),
            Observer(
              builder: (_) => _textField(
                labelText: 'email',
                onChange: controller.client.changeEmail,
                errorText: controller.validateEmail,
              ),
            ),
            SizedBox(height: 40),
            Observer(builder: (_) {
              return RaisedButton(
                onPressed: controller.isValid ? () {} : null,
                child: Text('Salvar'),
              );
            }),
          ],
        ),
      ),
    );
  }

  _textField({
    String labelText,
    Function onChange,
    String Function() errorText,
  }) =>
      TextField(
        onChanged: onChange,
        decoration: InputDecoration(
          border: OutlineInputBorder(),
          labelText: labelText,
          errorText: errorText == null ? null : errorText(),
        ),
      );
}
