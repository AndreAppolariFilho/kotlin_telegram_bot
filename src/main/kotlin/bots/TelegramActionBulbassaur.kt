package bots

import com.vdurmont.emoji.EmojiParser
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.objects.InputFile

class TelegramActionBulbassaur: ITelegramAction {
    override fun execute(bot: KotlinBot, chatId:String) {
        val text = EmojiParser.parseToUnicode("""
                    Então você prefere pokemons do tipo planta\. :four_leaf_clover: :four_leaf_clover:
                    Boa sorte em sua jornada treinador, cuide bem de seu pokemon e divirta\-se :smile:
                """.trimIndent()
        )
        val sendDocument = SendDocument().apply {
            this.chatId = chatId
            caption = text
            document = InputFile("https://media.giphy.com/media/LQNctmRkdaGWc/giphy.gif")
            parseMode = "MarkdownV2"
        }
        bot.execute(sendDocument)
    }
}