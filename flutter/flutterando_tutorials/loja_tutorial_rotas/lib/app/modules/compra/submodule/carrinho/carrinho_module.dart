import 'carrinho_controller.dart';
import 'package:flutter_modular/flutter_modular.dart';

import 'carrinho_page.dart';

class CarrinhoModule extends ChildModule {
  @override
  List<Bind> get binds => [
        $CarrinhoController,
      ];

  @override
  List<ModularRouter> get routers => [
        ModularRouter(
          '/:title',
          child: (_, args) => CarrinhoPage(
            title: args.params['title'],
          ),
        ),
      ];

  static Inject get to => Inject<CarrinhoModule>.of();
}
