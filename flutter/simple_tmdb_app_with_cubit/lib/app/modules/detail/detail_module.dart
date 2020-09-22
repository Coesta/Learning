import 'package:flutter_modular/flutter_modular.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/detail/presentation/pages/DetailPage.dart';

class DetailModule extends ChildModule {
  @override
  List<Bind> get binds => [];

  @override
  List<ModularRouter> get routers => [
        ModularRouter(
          '/detail',
          child: (_, args) => DetailPage(movie: args.data),
        ),
      ];
}
