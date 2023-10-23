package solutions.belov.tms_an_15_homework_lesson_21

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import solutions.belov.tms_an_15_homework_lesson_21.databinding.FragmentNoteListBinding

class NoteListFragment : Fragment() {
    private lateinit var binding: FragmentNoteListBinding
    private var notesList = mutableListOf<Note>()
    private lateinit var adapter: NoteAdapter
    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteListBinding.inflate(inflater, container, false)
        val view = binding.root



        viewModel = ViewModelProvider(requireActivity()).get(NotesViewModel::class.java)
        viewModel.getNotes().observe(viewLifecycleOwner, Observer { notes ->
            //notesList.clear()
            notesList.addAll(notes)
            Log.d("ZZZ", notes.toString())
            Log.d("ZZZZ", notesList.toString())

            //adapter.notifyItemInserted(notesList.size - 1)
        })

        adapter = NoteAdapter(notesList)
        binding.recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


        //adapter.setOnItemClickListener { note ->
        //}

        return view
    }
}


