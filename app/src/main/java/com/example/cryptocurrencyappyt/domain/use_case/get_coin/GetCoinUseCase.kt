package com.example.cryptocurrencyappyt.domain.use_case.get_coin

import com.example.cryptocurrencyappyt.common.Resource
import com.example.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.example.cryptocurrencyappyt.domain.model.Coin
import com.example.cryptocurrencyappyt.domain.model.CoinDetail
import com.example.cryptocurrencyappyt.domain.model.toCoin
import com.example.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository : CoinRepository
){
    operator fun invoke(coindId: String): kotlinx.coroutines.flow.Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coindId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
           emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Check your internet connection"))
        }
    }
}