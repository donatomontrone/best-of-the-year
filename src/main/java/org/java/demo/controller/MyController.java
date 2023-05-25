package org.java.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.java.demo.obj.Movie;
import org.java.demo.obj.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyController {
	private final static String MY_NAME = "Donato";
	private final static String MY_LASTNAME = "Montrone";
	
	@GetMapping("")
	public String getName(Model model) {
		model.addAttribute("name", MY_NAME);
		model.addAttribute("lastname", MY_LASTNAME);
		
		return "index";
	}
	
	private List<Movie> getBestMovies(){
		return Arrays.asList(new Movie[] {
				new Movie(1, "Avengers: Age of Ultron"),
				new Movie(2, "Guardian of the Galaxy Vol.3"),
				new Movie(3, "Avengers: Endgame"),
				new Movie(4, "Black Panther"),
				new Movie(5, "Spider-Man: No Way Home"),
				new Movie(6, "Iron Man 2")
		});
	}
	
	private List<Song> getBestSongs(){

		return Arrays.asList(new Song[] {
				new Song(1, "Welcome to the Jungle"),
				new Song(2, "Purple Rain"),
				new Song(3, "TNT"),
				new Song(4, "Back In Black"),
				new Song(5, "Otherside"),
				new Song(6, "Yesterdays")
		});
	}
	
	
	@GetMapping("/movies")
	public String movies(Model model) {
		List<Movie> movies = getBestMovies();

		model.addAttribute("movies", movies);
		return "movie-list";
	}
	
	@GetMapping("/songs")
	public String songs(Model model) {
		List<Song> songs = getBestSongs();

		model.addAttribute("songs", songs);
		return "song-list";
	}
	
	@GetMapping("/movies/{id}")
	public String moviesById(Model model, @PathVariable("id") int id) {
		List<Movie> movies = getBestMovies();
		Movie movie = null;
		
		for (Movie m : movies) {
			if (m.getId() == id) movie = m;
		}
		
		if (movie != null) model.addAttribute("movie",movie );
		return "movie";
	}
	
	@GetMapping("/songs/{id}")
	public String songsById(Model model, @PathVariable("id") int id) {
		List<Song> songs = getBestSongs();
		Song song = null;
		
		for (Song s : songs) {
			if (s.getId() == id) song = s;
		}
		
		if (song != null) model.addAttribute("song", song );
		
		return "song";
	}
}

