import 'package:flutter/material.dart';
import 'package:simple_tmdb_app/models/movie.dart';
import 'package:simple_tmdb_app/utils/constants.dart';
import 'package:intl/intl.dart';

class DetailPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final Movie movie = ModalRoute.of(context).settings.arguments as Movie;

    return Scaffold(
      appBar: AppBar(
        title: Text(movie.title),
      ),
      body: SafeArea(
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Image.network(
                "${Constants.BASE_API_URL_IMAGES}${movie.backdropPath}",
                fit: BoxFit.cover,
              ),
              Padding(
                padding: const EdgeInsets.only(top: 10),
                child: Text(
                  DateFormat('dd/MM/yyyy')
                      .format(DateTime.parse(movie.releaseDate)),
                  style: TextStyle(
                    fontSize: 16,
                    color: Colors.black54,
                  ),
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(10),
                child: Text(
                  movie.overview,
                  style: TextStyle(
                    fontSize: 25,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
