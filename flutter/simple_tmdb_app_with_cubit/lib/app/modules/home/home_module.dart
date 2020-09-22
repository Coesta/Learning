import 'package:flutter_modular/flutter_modular.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/data/datasources/home_datasource.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/data/repositories/home_repository_impl.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/repositories/home_repository_interface.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/usecases/get_popular_movies.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/presentation/controllers/home_controller_cubit.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/presentation/pages/home_page.dart';

class HomeModule extends ChildModule {
  @override
  List<Bind> get binds => [
        //Cubit,
        Bind(
          (i) => HomeControllerCubit(getPopularMovies: i.get()),
        ),
        // Repositories
        Bind<HomeRepositoryInterface>(
          (i) => HomeRepositoryImpl(homeDataSource: i.get()),
          lazy: true,
        ),
        //Datasources
        Bind<HomeDataSourceInterface>(
          (i) => HomeDataSourceImpl(dio: i.get()),
          lazy: true,
        ),
        Bind(
          (i) => GetPopularMovies(repository: i.get()),
          lazy: true,
        )
      ];

  @override
  List<ModularRouter> get routers => [
        ModularRouter(
          Modular.initialRoute,
          child: (_, args) => HomePage(
            controller: HomeModule.to.get(),
          ),
        )
      ];

  static Inject get to => Inject<HomeModule>.of();
}
