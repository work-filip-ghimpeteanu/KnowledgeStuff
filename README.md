# This covers some steps described in the 'Spring In Action 3rd Edition' Book


## 1. Multiple beans for same type
__|a|__ When having multiple possible beans (e.g. beans 'mike' & 'nino') we need to:
* define one bean to be primary (in order to avoid ambiguities, e.g. __NoUniqueBeanDefinitionException__)
* use __getBeansOfType__ context method in order to select a bean by it's id (otherwise it will use the primary bean
    when using __getBeans__ method)

__|b|__ When having multiple beans implementing the same interface (e.g. Performer) use the class type
instead of the interface type in the __getBeans__ method in order to avoid ambiguities exceptions (e.g.
__NoUniqueBeanDefinitionException__)