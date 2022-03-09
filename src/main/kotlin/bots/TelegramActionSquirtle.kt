package bots

import com.vdurmont.emoji.EmojiParser
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.objects.InputFile

class TelegramActionSquirtle: ITelegramAction  {
    override fun execute(bot: KotlinBot, chatId:String) {
        val text = EmojiParser.parseToUnicode("""
                    Então você prefere pokemons do tipo água\. :ocean: :ocean:
                    Boa sorte em sua jornada treinador, cuide bem de seu pokemon e divirta\-se :smile:
                """.trimIndent()
                )
        val sendDocument = SendDocument().apply {
            this.chatId = chatId
            caption = text
            document = InputFile("https://media.giphy.com/media/5fQyd7jM58m5y/giphy.gif")
            parseMode = "MarkdownV2"
        }
        bot.execute(sendDocument)
    }
}