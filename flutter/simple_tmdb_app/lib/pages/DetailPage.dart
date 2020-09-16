import 'package:flutter/material.dart';
import 'package:simple_tmdb_app/models/movie.dart';

class DetailPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final Movie movie = ModalRoute.of(context).settings.arguments as Movie;

    return Scaffold(
      appBar: AppBar(
        title: Text(movie.title),
      ),
    );
  }
}
