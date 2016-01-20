/**
 * 
 */
package com.xlncinc.core.filters;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;

/**
 * @author PAmbure
 *
 */
@WebFilter(urlPatterns={"/*"}, initParams={@WebInitParam(name="sessionFactoryBeanName", value="pmf")})
public class ClientOpenSessionInViewFilter extends OpenSessionInViewFilter{
}
