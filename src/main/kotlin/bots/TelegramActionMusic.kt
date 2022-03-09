package bots

import org.telegram.telegrambots.meta.api.methods.send.SendAudio
import org.telegram.telegrambots.meta.api.objects.InputFile
import java.io.File

class TelegramActionMusic:ITelegramAction {
    val filepath = "absolute_file_path"
    override fun execute(bot: KotlinBot, chatId:String) {
        val sendAudio = SendAudio().apply {
            this.chatId = chatId
            audio = InputFile(File(filepath))
            title = "gotta catch em all"
            caption = "musica para escutar enquanto você está na sua jornada pokémon"
        }
        bot.execute(sendAudio)
    }
}