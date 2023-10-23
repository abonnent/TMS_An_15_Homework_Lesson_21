package solutions.belov.tms_an_15_homework_lesson_21

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = NoteAdapter(notesList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(SpaceItemDecoration(16))

        viewModel = ViewModelProvider(requireActivity()).get(NotesViewModel::class.java)
        viewModel.getNotes().observe(viewLifecycleOwner, Observer { notes ->
            if (notes.isNotEmpty()) {
                with(binding) {
                    noNotes.isVisible = false
                    recyclerView.isVisible = true
                }

                notesList.clear()
                notesList.addAll(notes)
                adapter.notifyItemInserted(notesList.lastIndex)
            }
        })

        adapter.setOnItemClickListener { note ->
            val message = "Заметка:\n${note.title}\n${note.text}"

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, message)
            }

            val chooser = Intent.createChooser(sendIntent, getString(R.string.note_send))
            startActivity(chooser)
        }

        return view
    }
}


