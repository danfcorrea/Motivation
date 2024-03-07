package com.danfcorrea.motivation.data

import com.danfcorrea.motivation.models.MotivationConstants
import kotlin.random.Random

data class Message(val description: String, val category: String)

class Mock {
    private val all = MotivationConstants.FILTER.ALL
    private val happy = MotivationConstants.FILTER.HAPPY
    private val sunny = MotivationConstants.FILTER.SUN

    private val listMessages: List<Message> = listOf(
        Message("Não sabendo que era impossível, foi lá e fez.", happy),
        Message("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        Message("Quando está mais escuro, vemos mais estrelas!", happy),
        Message("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        Message("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        Message("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Message("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Message("Você perde todas as chances que você não aproveita.", sunny),
        Message("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Message("Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Message("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Message("Se você acredita, faz toda a diferença.", sunny),
        Message("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getPhrase(category: String): String {
        val filtered = listMessages.filter { (it.category == category || category == all) }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }
}