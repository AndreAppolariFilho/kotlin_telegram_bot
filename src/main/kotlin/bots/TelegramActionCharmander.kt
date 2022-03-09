package bots

import com.vdurmont.emoji.EmojiParser
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.objects.InputFile

class TelegramActionCharmander: ITelegramAction {
    override fun execute(bot: KotlinBot, chatId:String) {
        val text = EmojiParser.parseToUnicode("""
                   Então você prefere pokemons do tipo fogo\. :fire: :fire:
                    Boa sorte em sua jornada treinador, cuide bem de seu pokemon e divirta\-se :smile:
                """.trimIndent()
        )
        val sendDocument = SendDocument().apply {
            this.chatId = chatId
            this.caption = text
            document = InputFile("https://media.giphy.com/media/u1k1kpDZSw5sA/giphy.gif")
            parseMode = "MarkdownV2"
        }
        bot.execute(sendDocument)
    }

}