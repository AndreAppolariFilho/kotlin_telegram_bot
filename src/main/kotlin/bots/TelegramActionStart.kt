package bots

import com.vdurmont.emoji.EmojiParser
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.objects.InputFile

class TelegramActionStart : ITelegramAction {
    override fun execute(bot: KotlinBot, chatId:String)
    {
        val nameSender = bot.nameSender
        val welcome = EmojiParser.parseToUnicode("""
                    
                    Olá $nameSender, tudo bem? :smile: 
                    
                    *Bora testar os comandos a seguir?*
                    
                    /start \- mensagem inicial
                    /pokemon \- escolha um pokemon inicial
                    /gameplay \- assista um video de gameplay do jogo
                    /music \- musica para escutar enquanto você está na sua jornada pokémon
                """.trimIndent()
        )

        val sendDocument = SendDocument().apply {
            this.chatId = chatId
            caption = welcome
            document = InputFile("https://media.giphy.com/media/cQNRp4QA8z7B6/giphy.gif")
            parseMode = "MarkdownV2"
        }
        bot.execute(sendDocument)


    }
}