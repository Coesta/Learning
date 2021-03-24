import 'package:mobx/mobx.dart';
import 'package:mobx_cart_list/models/client.dart';
part 'controller.g.dart';

class Controller = _ControllerBase with _$Controller;

abstract class _ControllerBase with Store {
  final client = Client();

  @computed
  bool get isValid => validateName() == null && validateEmail() == null;

  String validateName() {
    if (client.name == null || client.name.isEmpty)
      return "campo obrigatório";
    else if (client.name.length < 4)
      return 'precisa ter mais de 3 letras';
    else
      return null;
  }

  String validateEmail() {
    if (client.email == null || client.email.isEmpty)
      return "campo obrigatório";
    else if (!client.email.contains('@'))
      return 'inválido';
    else
      return null;
  }
}
