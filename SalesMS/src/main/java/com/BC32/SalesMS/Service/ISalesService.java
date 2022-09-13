package com.BC32.SalesMS.Service;

import com.BC32.SalesMS.Model.Sales;
import reactor.core.publisher.Flux;

public interface ISalesService extends ICRUD<Sales, Integer>{

    Flux<Sales> getSalesListByidClient(Integer idClient);
}
