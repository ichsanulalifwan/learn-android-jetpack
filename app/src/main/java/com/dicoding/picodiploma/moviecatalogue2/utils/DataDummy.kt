package com.dicoding.picodiploma.moviecatalogue2.utils

import com.dicoding.picodiploma.moviecatalogue2.data.MovieResultsItem
import com.dicoding.picodiploma.moviecatalogue2.data.TvShowResultsItem
import com.dicoding.picodiploma.moviecatalogue2.data.response.GenresItem
import com.dicoding.picodiploma.moviecatalogue2.data.response.MovieDetailResponse
import com.dicoding.picodiploma.moviecatalogue2.data.response.TvShowDetailResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieResultsItem> {

        val movies = ArrayList<MovieResultsItem>()

        movies.add(
            MovieResultsItem(
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2018",
                10,
                "Bohemian Rhapsody",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
            )
        )

        movies.add(
            MovieResultsItem(
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018",
                11,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"
            )
        )

        movies.add(
            MovieResultsItem(
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "2021",
                12,
                "Raya and the Last Dragon",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"
            )
        )
        return movies
    }

    fun generateDummyTvShow(): List<TvShowResultsItem> {

        val tvshow = ArrayList<TvShowResultsItem>()

        tvshow.add(
            TvShowResultsItem(
                "2017",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Riverdale",
                21,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
            )
        )


        tvshow.add(
            TvShowResultsItem(
                "2015",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "Supergirl",
                22,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg"
            )
        )

        tvshow.add(
            TvShowResultsItem(
                "2019",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "The Umbrella Academy",
                23,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg"
            )
        )
        return tvshow
    }

    fun generateDummyDetailMovies(): List<MovieDetailResponse> {

        val detailMovies = ArrayList<MovieDetailResponse>()

        detailMovies.add(
            MovieDetailResponse(
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2018",
                generateDummyGenres(),
                8.0,
                135,
                "Fearless lives forever",
                10,
                "Bohemian Rhapsody",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Released"
            )
        )

        detailMovies.add(
            MovieDetailResponse(
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018",
                generateDummyGenres(),
                6.6,
                134,
                "Fate of One. Future of All.",
                11,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Released"
            )
        )

        detailMovies.add(
            MovieDetailResponse(
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "2021",
                generateDummyGenres(),
                7.4,
                107,
                "A quest to save her world.",
                12,
                "Raya and the Last Dragon",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "Released"
            )
        )
        return detailMovies
    }

    fun generateDummyDetailTv(): List<TvShowDetailResponse> {

        val detailTv = ArrayList<TvShowDetailResponse>()

        detailTv.add(
            TvShowDetailResponse(
                "2017",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                87,
                "Scripted",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                generateDummyGenres(),
                8.6,
                "Riverdale",
                "Small town. Big secrets.",
                21,
                5,
                "Returning Series"
            )
        )

        detailTv.add(
            TvShowDetailResponse(
                "2015",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                118,
                "Scripted",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg",
                generateDummyGenres(),
                6.12,
                "Supergirl",
                "A force against fear",
                22,
                6,
                "Returning Series"
            )
        )

        detailTv.add(
            TvShowDetailResponse(
                "2019",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                20,
                "Scripted",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
                generateDummyGenres(),
                8.7,
                "The Umbrella Academy",
                "Super. Dysfunctional. Family.",
                23,
                2,
                "Returning Series"
            )
        )
        return detailTv
    }

    fun generateDummyGenres(): List<GenresItem> {

        val genreItem = ArrayList<GenresItem>()

        genreItem.add(
            GenresItem(
                "Mystery",
                9648
            )
        )

        genreItem.add(
            GenresItem(
                "Drama",
                18
            )
        )

        genreItem.add(
            GenresItem(
                "Crime",
                80
            )
        )
        return genreItem
    }
}