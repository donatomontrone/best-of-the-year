package org.java.demo.controller;

import java.util.ArrayList;
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
		List<Movie> movies = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			Movie m = new Movie(i, "Movie - " + i);
			
			movies.add(m);
		}
		
		return movies;
	}
	
	private List<Song> getBestSongs(){
		List<Song> songs = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			Song m = new Song(i, "Song - " + i);
			
			songs.add(m);
		}
		
		return songs;
	}
	
	
	@GetMapping("/movies")
	public String movies(Model model) {
		String movieStr = "";
		List<Movie> movies = getBestMovies();
//		for (Movie m : movies) {
//			movieStr += m + ", ";
//		}
	
		for (int i = 0; i < movies.size(); i++) {
			if (i != movies.size() - 1) {
				movieStr += movies.get(i) + ",  ";
			} else {
				movieStr += movies.get(i) + ".";
				
			}
		}
		model.addAttribute("movies", movieStr);
		return "lists";
	}
	
	@GetMapping("/songs")
	public String songs(Model model) {
		List<Song> songs = getBestSongs();
		String songsStr = "";
		for (int i = 0; i < songs.size(); i++) {
			if (i != songs.size() - 1) {
				songsStr += songs.get(i) + ",  ";
			} else {
				songsStr += songs.get(i) + ".";
				
			}
		}
		model.addAttribute("songs", songsStr);
		return "lists";
	}
	
	@GetMapping("/movies/{id}")
	public String moviesById(Model model, @PathVariable("id") int id) {
		List<Movie> movies = getBestMovies();
		String movie = "";
		
		for (Movie m : movies) {
			if (m.getId() == id) movie = m.getTitle();
		}
		
		model.addAttribute("movie", movie);
		return "movie";
	}
	
	@GetMapping("/songs/{id}")
	public String songsById(Model model, @PathVariable("id") int id) {
		List<Song> songs = getBestSongs();
		String song = "";
		
		for (Song s : songs) {
			if (s.getId() == id) song = s.getTitle();
		}
		
		model.addAttribute("song", song);
		return "song";
	}
}

