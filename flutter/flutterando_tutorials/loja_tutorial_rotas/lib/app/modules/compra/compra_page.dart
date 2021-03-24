import 'package:flutter/material.dart';
import 'package:flutter_modular/flutter_modular.dart';
import 'package:loja_tutorial_rotas/app/modules/shared/produto_model.dart';
import 'compra_controller.dart';

class CompraPage extends StatefulWidget {
  final ProdutoModel produtoModel;
  final String title;

  const CompraPage({
    Key key,
    this.title = "Compra",
    @required this.produtoModel,
  }) : super(key: key);

  @override
  _CompraPageState createState() => _CompraPageState();
}

class _CompraPageState extends ModularState<CompraPage, CompraController> {
  //use 'controller' variable to access controller

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.produtoModel.nome),
        actions: [
          IconButton(
            icon: Icon(Icons.shopping_cart),
            onPressed: () =>
                Modular.link.pushNamed('/carrinho/vindo do M compra'),
          )
        ],
      ),
      body: Column(
        children: <Widget>[
          Card(
            child: Padding(
              padding: const EdgeInsets.all(15),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text('Produto: ${widget.produtoModel.nome}'),
                  Text('Preço: R\$${widget.produtoModel.preco}'),
                ],
              ),
            ),
          )
        ],
      ),
    );
  }
}
