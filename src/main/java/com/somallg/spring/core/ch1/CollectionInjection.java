package com.somallg.spring.core.ch1;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {

    private Map<String, Object> map;

    private Properties props;

    @SuppressWarnings("rawtypes")
    private Set set;

    @SuppressWarnings("rawtypes")
    private List list;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @SuppressWarnings("rawtypes")
    public Set getSet() {
        return set;
    }

    @SuppressWarnings("rawtypes")
    public void setSet(Set set) {
        this.set = set;
    }

    @SuppressWarnings("rawtypes")
    public List getList() {
        return list;
    }

    @SuppressWarnings("rawtypes")
    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CollectionInjection{" +
                "map=" + map +
                ", props=" + props +
                ", set=" + set +
                ", list=" + list +
                '}';
    }
}
