import 'package:flutter/material.dart';
import 'package:flutter_modular/flutter_modular.dart';
import 'package:simple_tmdb_app_with_cubit/app/core/utils/constants.dart';
import 'package:simple_tmdb_app_with_cubit/app/modules/home/domain/entities/movie.dart';

class MovieItem extends StatelessWidget {
  final Movie movie;

  const MovieItem({Key key, this.movie}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: InkWell(
        // onTap: () {},
        onTap: () => Modular.to.pushNamed('/detail', arguments: movie),
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
                  if (movie.voteAverage > 0)
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
                              movie.voteAverage.toString(),
                              style: TextStyle(
                                fontSize: 15,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                  if (movie.voteAverage == 0)
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
