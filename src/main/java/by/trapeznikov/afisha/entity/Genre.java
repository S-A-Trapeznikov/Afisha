package by.trapeznikov.entity;

public enum Genre {
COMEDY, HORROR, DRAMA;

 public static Genre getGenre (String genreString) {
	Genre genre = null;
	switch (genreString){
	case "comedy":  genre =  Genre.COMEDY;
					break;
	case "horror":  genre = Genre.HORROR;
					break;
	case "drama":   genre = Genre.DRAMA;
					break;
	
	}
	return genre;
}

 public static String getGenreString (Genre genre) {
	String genreString = null;
	switch (genre){
	case COMEDY:  genreString =  "comedy";
					break;
	case HORROR:  genreString = "horror";
					break;
	case DRAMA:   genreString = "drama";
					break;
	
	}
	return genreString;
}

}
