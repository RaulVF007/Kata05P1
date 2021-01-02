package kata05p1;

import java.util.List;

public class MailHistogramBuilder extends Histogram{

    public static Histogram<String> build(List<Mail> mailList) {
        Histogram <String> histogram = new Histogram();
        for (Mail mail: mailList){
            histogram.increment(mail.getDomain());
        }     
        return histogram;
    }
}