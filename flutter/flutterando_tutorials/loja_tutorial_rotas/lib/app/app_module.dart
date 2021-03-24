import 'package:loja_tutorial_rotas/app/modules/compra/compra_module.dart';
import 'package:loja_tutorial_rotas/app/modules/loja/loja_module.dart';
import 'package:loja_tutorial_rotas/app/modules/produto/produto_module.dart';

import 'app_controller.dart';
import 'package:flutter_modular/flutter_modular.dart';
import 'package:flutter/material.dart';
import 'package:loja_tutorial_rotas/app/app_widget.dart';

class AppModule extends MainModule {
  @override
  List<Bind> get binds => [
        $AppController,
      ];

  @override
  List<ModularRouter> get routers => [
        ModularRouter(Modular.initialRoute, module: LojaModule()),
        ModularRouter('/produto', module: ProdutoModule()),
        ModularRouter('/compra', module: CompraModule()),
      ];

  @override
  Widget get bootstrap => AppWidget();

  static Inject get to => Inject<AppModule>.of();
}
