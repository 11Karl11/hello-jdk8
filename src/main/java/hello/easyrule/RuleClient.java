// package hello.easyrule;
//
// import org.apache.tomcat.util.digester.Rules;
// import org.jeasy.rules.api.Facts;
// import org.jeasy.rules.api.RulesEngine;
// import org.jeasy.rules.core.DefaultRulesEngine;
// import org.jeasy.rules.core.RulesEngineParameters;
//
// /**
//  * @author karl xie
//  * Created on 2020-10-09 13:26
//  */
// public class RuleClient {
//     public static void main(String[] args) {
//         // create a rules engine
//         RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
//         RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);
//
//         // create rules
//         Rules rules = new Rules();
//         rules.register(new FizzRule());
//         rules.register(new BuzzRule());
//         rules.register(new RuleClass.FizzBuzzRule(new RuleClass.FizzRule(), new RuleClass.BuzzRule()));
//         rules.register(new NonFizzBuzzRule());
//
//         // fire rules
//         Facts facts = new Facts();
//         for (int i = 1; i <= 100; i++) {
//             facts.put("number", i);
//             fizzBuzzEngine.fire(rules, facts);
//             System.out.println();
//         }
//     }
//
// }