package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String getCars(@RequestParam(value = "count", defaultValue = "5") Long count,
						  ModelMap model){
		Car carOne=new Car("BMW","M3",1993);
		Car carTwo=new Car("Mersedes","AMG",2000);
		Car carThree=new Car("Mazda","CX5",2005);
		Car carFour=new Car("LandCruiser","Prado",2010);
		Car carFifth=new Car("Nissan","Quashkai",2012);

		List<Car> list=new ArrayList<>();

		list.add(carOne);
		list.add(carTwo);
		list.add(carThree);
		list.add(carFour);
		list.add(carFifth);

        List<Car> sortedList=list.stream()
                .limit(count)
                .collect(Collectors.toList());

		model.addAttribute("car",sortedList);

		return "cars";
	}
	
}