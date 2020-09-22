import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:simple_tmdb_app_with_cubit/app/core/utils/constants.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/entities/movie.dart';

class DetailPage extends StatefulWidget {
  final Movie movie;

  const DetailPage({
    Key key,
    @required this.movie,
  }) : super(key: key);

  @override
  _DetailPageState createState() => _DetailPageState();
}

class _DetailPageState extends State<DetailPage> {
  @override
  Widget build(BuildContext context) {
    // final Movie movie = ModalRoute.of(context).settings.arguments as Movie;

    return Scaffold(
      appBar: AppBar(
        title: Text(widget.movie.title),
      ),
      body: SafeArea(
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Image.network(
                "${Constants.BASE_API_URL_IMAGES}${widget.movie.backdropPath}",
                fit: BoxFit.cover,
              ),
              Padding(
                padding: const EdgeInsets.only(top: 10),
                child: Text(
                  DateFormat('dd/MM/yyyy').format(widget.movie.releaseDate),
                  style: TextStyle(
                    fontSize: 18,
                    color: Colors.black54,
                  ),
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 10),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text('Original Language ', style: TextStyle(fontSize: 16)),
                    Container(
                      child: Text(widget.movie.originalLanguage,
                          style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                          )),
                      padding: EdgeInsets.all(10),
                      decoration: BoxDecoration(
                        color: Colors.black38,
                        borderRadius: BorderRadius.all(Radius.circular(5)),
                      ),
                    ),
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(10),
                child: Text(
                  widget.movie.overview,
                  style: TextStyle(fontSize: 22),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
