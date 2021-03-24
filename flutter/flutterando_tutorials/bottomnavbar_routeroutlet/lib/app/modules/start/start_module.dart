import 'package:bottomnavbar_routeroutlet/app/modules/start/pages/perfil/perfil_page.dart';

import 'pages/config/config_controller.dart';
import 'pages/perfil/perfil_controller.dart';
import 'start_controller.dart';
import 'package:flutter_modular/flutter_modular.dart';

import 'start_page.dart';

class StartModule extends ChildModule {
  @override
  List<Bind> get binds => [
        $ConfigController,
        $PerfilController,
        $StartController,
      ];

  @override
  List<ModularRouter> get routers => [
        ModularRouter(Modular.initialRoute, child: (_, args) => StartPage()),
        ModularRouter('/perfil', child: (_, args) => PerfilPage()),
      ];

  static Inject get to => Inject<StartModule>.of();
}
