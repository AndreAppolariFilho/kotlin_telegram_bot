package bots

import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class TelegramActionPokemon: ITelegramAction {
    override fun execute(bot: KotlinBot, chatId:String) {
        val buttons = listOf(
                listOf(
                        InlineKeyboardButton().apply{
                            text = "Charmander"
                            callbackData = "/charmander"
                        },
                        InlineKeyboardButton().apply{
                            text = "Bulbassaur"
                            callbackData = "/bulbassaur"
                        },
                        InlineKeyboardButton().apply{
                            text = "Squirtle"
                            callbackData = "/squirtle"
                        }
                )
        )
        val options = InlineKeyboardMarkup().apply {
            keyboard = buttons
        }
        val sendDocument = SendDocument().apply{
            this.chatId = chatId
            document = InputFile().setMedia("https://media.giphy.com/media/2ijQDh7AsWdEoMkdQ6/giphy.gif")
            caption = "Qual será o seu pokémon inicial?"
            replyMarkup = options
        }


        bot.execute(sendDocument)
    }

}