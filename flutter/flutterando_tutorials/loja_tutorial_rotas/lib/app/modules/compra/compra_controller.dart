import 'package:mobx/mobx.dart';
import 'package:flutter_modular/flutter_modular.dart';

part 'compra_controller.g.dart';

@Injectable()
class CompraController = _CompraControllerBase with _$CompraController;

abstract class _CompraControllerBase with Store {
  @observable
  int value = 0;

  @action
  void increment() {
    value++;
  }
}
