package solutions.belov.tms_an_15_homework_lesson_21

data class Note(
    val title: String,
    val text: String,
    val date: String,
    val important: Boolean = false
)