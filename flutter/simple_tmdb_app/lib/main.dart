import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:simple_tmdb_app/pages/DetailPage.dart';
import 'package:simple_tmdb_app/pages/HomePage.dart';
import 'package:simple_tmdb_app/providers/movies.dart';
import 'package:simple_tmdb_app/utils/app_routes.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (_) => Movies(),
      child: MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          primarySwatch: Colors.blue,
          fontFamily: 'Lato',
          visualDensity: VisualDensity.adaptivePlatformDensity,
        ),
        routes: {
          AppRoutes.HOME: (context) => HomePage(),
          AppRoutes.MOVIE_DETAIL: (context) => DetailPage(),
        },
      ),
    );
  }
}
