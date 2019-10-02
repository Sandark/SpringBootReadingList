package io.sandark.readinglist.controller

import io.sandark.readinglist.dao.ReadingListRepository
import io.sandark.readinglist.entity.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/")
class ReadingListController @Autowired constructor(var readingListRepository: ReadingListRepository) {

    @RequestMapping("/{reader}", method = [RequestMethod.GET])
    fun readersBooks(@PathVariable("reader") reader: String, model: Model): String {

        val readingList: List<Book>? = readingListRepository.findByReader(reader)
        if (readingList != null) {
            model.addAttribute("books", readingList)
        }
        return "readingList"
    }

    @RequestMapping("/{reader}", method = [RequestMethod.POST])
    fun addToReadingList(@PathVariable("reader") reader: String, book: Book): String {
        book.reader = reader
        readingListRepository.save(book)
        return "redirect:/{reader}"
    }
}