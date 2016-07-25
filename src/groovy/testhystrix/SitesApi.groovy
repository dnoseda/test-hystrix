package testhystrix

import com.netflix.hystrix.*

class SitesApi extends HystrixCommand<String> {

	private final String name;
	public SitesApi(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("SitesApi"));
        this.name = name;
    }

    @Override
    protected String run() {
        return "Hello " + name + "!";
    }
}