package uk.gov.dvsa.moti.web.bundle.helper;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import io.dropwizard.views.View;
import uk.gov.dvsa.moti.web.routing.FraudRoutes;

import java.io.IOException;

public class FormUrlViewHelper implements Helper<View> {
    public static final String NAME = "url_form";

    public String apply(View context, Options options) throws IOException {

        return FraudRoutes.getFormPath();
    }
}
