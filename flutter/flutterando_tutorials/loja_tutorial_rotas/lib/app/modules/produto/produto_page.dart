import 'package:flutter/material.dart';
import 'package:flutter_modular/flutter_modular.dart';
import 'package:loja_tutorial_rotas/app/modules/shared/produto_model.dart';
import 'produto_controller.dart';

class ProdutoPage extends StatefulWidget {
  final String nomeLoja;
  const ProdutoPage({
    Key key,
    @required this.nomeLoja,
  }) : super(key: key);

  @override
  _ProdutoPageState createState() => _ProdutoPageState();
}

class _ProdutoPageState extends ModularState<ProdutoPage, ProdutoController> {
  //use 'controller' variable to access controller

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.nomeLoja),
      ),
      body: ListView.builder(
        itemCount: 20,
        itemBuilder: (BuildContext context, int index) => ListTile(
          onTap: () => Modular.to.pushNamed(
            '/compra',
            arguments: ProdutoModel(
              id: index,
              nome: 'Produto $index',
              preco: 3.0 * index,
            ),
          ),
          title: Text('Produto $index'),
          subtitle: Text('Melhor Produto'),
          leading: CircleAvatar(
            child: Text('P$index'),
          ),
        ),
      ),
    );
  }
}
