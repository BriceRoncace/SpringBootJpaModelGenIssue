package gov.idaho.isp.bootvalidation.domain.controller;

import gov.idaho.isp.bootvalidation.domain.Widget;
import gov.idaho.isp.bootvalidation.domain.WidgetRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WidgetController {
  private final WidgetRepository widgetRepository;

  public WidgetController(WidgetRepository widgetRepository) {
    this.widgetRepository = widgetRepository;
  }

  @GetMapping("/")
  public List<Widget> findWidgets() {
    return widgetRepository.findAll();
  }

  @GetMapping("/save")
  public List<Widget> saveWidgets(Widget widget) {
    widgetRepository.save(widget);
    return widgetRepository.findAll();
  }
}
