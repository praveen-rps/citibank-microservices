package com.example.noteapp1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NoteController {
	
	@Autowired
	NoteService service;
	
	
	
	@GetMapping("/searchComments/{pid}")
	public List<CommentsDto> findCommentsOnPid(@PathVariable("pid")String pid){
		return service.findCommentsByPid(pid);
	}
	
	@GetMapping("/search/{pid}")
	public Optional<Note> findNotes(@PathVariable("pid") String pid) {
		return service.searchByNoteId(pid);
	}
	
	@DeleteMapping("/delete/{pid}")
	public String deleteNotes(@PathVariable("pid") String pid) {
		service.deleteNoteById(pid);
		return "Note Deleted";
	}
	
	@GetMapping("/all")
	public List<Note> findAll(){
		return service.showAll();
	}
	
	@GetMapping("/find/{title}")
	public List<Note> findAllByTitle(@PathVariable("title")String title){
		return service.searchByTitle(title);
	}
	
	@GetMapping("/find/{title}/{author}")
	public List<Note> findAllByTitleandAuthor(@PathVariable("title")String title,
			@PathVariable("author")String author){
		return service.searchByTitleandAuthor(title, author);
	}
	
	@PostMapping("/add")
	public Note addNote(@RequestBody Note note) {
		return service.addNotes(note);
	}
}
