package ecommerce.webflux.service.app.application.queries;

import javax.validation.Valid;

public interface QueryHandler<T extends Query, R> {

  R execute(@Valid T query);

}
