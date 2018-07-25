package br.com.gabrielspassos.poc;

import io.reactivex.Observable;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class RxJavaTest {

    @Test
    public void mustReturnHelloGabriel() {

        Observable<String> observable = Observable.just("Hello");
        observable.subscribe(s -> {
            String result = s;
            assertTrue(result.equals("Hello"));
        });
    }

    @Test
    public void mustReturnObserver(){
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        Observable<String> observable = Observable.fromArray(letters);
        observable.subscribe(() -> {
                i -> String result += i,  //OnNext
                Throwable::printStackTrace, //OnError
                () -> result += "_Completed" //OnCompleted
        });
        assertTrue(result.equals("abcdefg_Completed"));
    }

    @Test
    public void mustUpperCase() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        String result = "";
        Observable.fromArray(letters)
                .map(String::toUpperCase)
                .subscribe(letter -> result += letter);

        assertTrue(result.equals("ABCDEFG"));
    }
}
