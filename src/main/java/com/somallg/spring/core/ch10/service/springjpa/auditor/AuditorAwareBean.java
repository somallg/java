package com.somallg.spring.core.ch10.service.springjpa.auditor;

import org.springframework.data.domain.AuditorAware;

/**
 * Created by somallg on 12/8/14.
 */
public class AuditorAwareBean implements AuditorAware<String> {
    @Override
    public String getCurrentAuditor() {
        return "somallg";
    }
}
