package bots


import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

class KotlinBot : TelegramLongPollingBot() {
    var nameSender:String? = null
    override fun getBotUsername(): String {
        //return bot username
        // If bot username is @HelloKotlinBot, it must return
        return "HelloKotlinBot"
    }

    override fun getBotToken(): String {
        // Return bot token from BotFather
        return "[token]"
    }
    private fun getTelegramAction(message:String?, isCallback:Boolean):ITelegramAction{
        var telegramAction:ITelegramAction  = TelegramActionError()
        if(isCallback)
        {
            telegramAction = when(message){
                "/charmander" -> TelegramActionCharmander()
                "/squirtle" -> TelegramActionSquirtle()
                "/bulbassaur" -> TelegramActionBulbassaur()
                else -> telegramAction

            }
        }
        else {
            telegramAction = when(message)
            {
                "/start" -> TelegramActionStart()
                "/pokemon" -> TelegramActionPokemon()
                "/gameplay" -> TelegramActionGameplay()
                "/music" -> TelegramActionMusic()
                else -> telegramAction
            }

        }
        return telegramAction
    }
    override fun onUpdateReceived(update: Update?) {
        // We check if the update has a message and the message has text
        nameSender = update?.message?.from?.firstName
        val chatId = update?.callbackQuery?.message?.chatId
                ?:update?.message?.chatId
        try {
            update?.callbackQuery?.let {
                getTelegramAction(update?.callbackQuery?.data, true).execute(this, chatId.toString())
            } ?: getTelegramAction(update?.message?.text, false).execute(this, chatId.toString());

        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}