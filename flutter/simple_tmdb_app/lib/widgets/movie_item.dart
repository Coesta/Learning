import 'package:flutter/material.dart';
import 'package:simple_tmdb_app/models/movie.dart';
import 'package:simple_tmdb_app/utils/app_routes.dart';
import 'package:simple_tmdb_app/utils/constants.dart';

class MovieItem extends StatelessWidget {
  final Movie movie;

  const MovieItem({Key key, this.movie}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: InkWell(
        onTap: () => Navigator.of(context)
            .pushNamed(AppRoutes.MOVIE_DETAIL, arguments: movie),
        child: Column(
          children: [
            Image.network(
              "${Constants.BASE_API_URL_IMAGES}${movie.backdropPath}",
              fit: BoxFit.cover,
            ),
            Padding(
              padding: const EdgeInsets.all(14),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Expanded(
                    flex: 3,
                    child: Text(
                      movie.title,
                      style: TextStyle(
                        fontSize: 16,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  if (double.parse(movie.voteAverage) > 0)
                    Expanded(
                      flex: 1,
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.end,
                        children: [
                          Icon(
                            Icons.stars,
                            color: Colors.yellow[800],
                          ),
                          Padding(
                            padding: const EdgeInsets.only(left: 6),
                            child: Text(
                              movie.voteAverage,
                              style: TextStyle(
                                fontSize: 15,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                  if (double.parse(movie.voteAverage) == 0)
                    Icon(
                      Icons.stars,
                      color: Colors.grey,
                    ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
