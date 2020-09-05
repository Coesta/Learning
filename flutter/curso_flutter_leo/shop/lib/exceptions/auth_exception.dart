class AuthException implements Exception {
  static const Map<String, String> errors = {
    "EMAIL_EXISTS": "O endereço de email já está sendo usado por outra conta.",
    "OPERATION_NOT_ALLOWED": "Operação não permitida.",
    "TOO_MANY_ATTEMPTS_TRY_LATER": "",
    "EMAIL_NOT_FOUND": "E-mail não encontrado!",
    "INVALID_PASSWORD": "Senha inválida.",
    "USER_DISABLED": "A conta foi desativada por um administrador.",
  };

  final String key;
  const AuthException(this.key);

  @override
  String toString() {
    if (errors.containsKey(key)) {
      return errors[key];
    } else {
      return 'Ocorreu um erro na autenticação!';
    }
  }
}
