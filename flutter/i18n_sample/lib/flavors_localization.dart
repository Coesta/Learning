class FlavorsLocalization {
  String flavor;

  FlavorsLocalization(this.flavor);

  static Map<String, Map<String, String>> _localizedValues = {
    'principal': {
      'wellcome': 'Seja bem vindo',
    },
    'flavor-one': {
      'wellcome': 'Fala moral',
    },
    'flavor-two': {
      'wellcome': 'Iai meu consagrado',
    },
    'default': {
      'wellcome': 'Bem vindo',
    },
  };

  String get wellcome {
    return _localizedValues[flavor]['wellcome'];
  }
}
