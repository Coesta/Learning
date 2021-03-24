import 'package:mobx/mobx.dart';
import 'package:flutter_modular/flutter_modular.dart';

part 'produto_controller.g.dart';

@Injectable()
class ProdutoController = _ProdutoControllerBase with _$ProdutoController;

abstract class _ProdutoControllerBase with Store {
  @observable
  int value = 0;

  @action
  void increment() {
    value++;
  }
}
