package bots

import org.telegram.telegrambots.meta.api.methods.send.SendVideo
import org.telegram.telegrambots.meta.api.objects.InputFile
import java.io.File

class TelegramActionGameplay:ITelegramAction {
    val filepath = "absolute_file_path"
    override fun execute(bot: KotlinBot, chatId:String) {
        val sendVideo = SendVideo().apply {
            this.chatId = chatId
            this.video = InputFile(File(filepath))
            caption = "Gameplay nice"
        }
        bot.execute(sendVideo)
    }
}