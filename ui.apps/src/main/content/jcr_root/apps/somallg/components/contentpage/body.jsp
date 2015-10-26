<%@include file="/libs/foundation/global.jsp" %>
<body>
	<header class="top">
		<cq:include path="headerLogo" resourceType="somallg/components/logo"/>
	</header>

    <nav>
    	<cq:include path="topnav" resourceType="somallg/components/topnav"/>
    </nav>

	<div id="tableContainer">
		<div id="tableRow">
			<section id="drinks">
				<h1>BEVERAGES</h1>
				<p>House Blend, $1.49</p>
				<p>Mocha Cafe Latte, $2.35</p>
				<p>Cappuccino, $1.89</p>
				<p>Chai Tea, $1.85</p>
				<h1>ELIXIRS</h1>
				<p>We proudly serve elixirs brewed by our friends at the Head
					First Lounge.</p>
				<p>Green Tea Cooler, $2.99</p>
				<p>Raspberry Ice Concentration, $2.99</p>
				<p>Blueberry Bliss Elixir, $2.99</p>
				<p>Cranberry Antioxidant Blast, $2.99</p>
				<p>Chai Chiller, $2.99</p>
				<p>Black Brain Brew, $2.99</p>

				<div id="coupon">
					<a href="freecoffee.html"
						title="Click here to get your free coffee"> <img
						src="../../dam/somallg/images/ticket.gif"
						alt="Starbuzz coupon ticket">
					</a>
				</div>
			</section>

			<section id="main">
				<article>
					<header>
						<h1>Starbuzz launches...Tweet Sip</h1>
						<time datetime="2012-05-03">5/3/2012</time>
					</header>
					<p>As promised, today I'm proud to announce that Starbuzz
						Coffee is launching the Tweet Sip cup, a special Starbuzz Coffee
						cup that tweets each time you take a sip! Check out my video of
						our new invention.</p>
					<video controls  autoplay width="512" height="288">
						   <source src="../../dam/somallg/video/tweetsip.mp4">
						   <source src="../../dam/somallg/video/tweetsip.webm">
						   <source src="../../dam/somallg/video/tweetsip.ogv">
					</video>

				</article>


				<article>
					<header>
						<h1>QUALITY COFFEE, QUALITY CAFFEINE</h1>
						<time datetime="2012-03-12">3/12/2012</time>
					</header>
					<p>At Starbuzz Coffee, we are dedicated to filling all your
						caffeine needs through our quality coffees and teas. Sure, we want
						you to have a great cup of coffee and a great coffee experience as

						well, but we're the only company that actively monitors and
						optimizes caffeine levels. So stop by and fill your cup, or order
						online with our new Bean Machine online order form, and get that
						quality Starbuzz coffee that you know will meet your caffeine
						standards.</p>
					<p>
						And, did we mention <em>caffeine</em>? We've just started funding
						the guys doing all the wonderful research at the <a
							href="http://buzz.wickedlysmart.com"
							title="Read all about caffeine on the Buzz">Caffeine Buzz</a>. If
						you want the latest on coffee and other caffeine products, stop by
						and pay them a visit.
					</p>
				</article>

				<article>
					<header>
						<h1>OUR STORY</h1>
						<time datetime="2012-03-10">3/10/2012</time>
					</header>
					<p>"A man, a plan, a coffee bean". Okay, that doesn't make a
						palindrome, but it resulted in a damn good cup of coffee.
						Starbuzz's CEO is that man, and you already know his plan: a
						Starbuzz on every corner.</p>
					<p>In only a few years he's executed that plan and today you
						can enjoy Starbuzz just about anywhere. And, of course, the big
						news this year is that Starbuzz teamed up with Head First readers
						to create Starbuzz's Web presence, which is growing rapidly and
						helping to meet the caffeine needs of a whole new set of
						customers.</p>
				</article>

				<article>
					<header>
						<h1>STARBUZZ COFFEE BEVERAGES</h1>
						<time datetime="2012-02-18">2/18/2012</time>
					</header>
					<p>
						We've got a variety of caffeinated beverages to choose from at
						Starbuzz, including our <a href="beverages.html#house"
							title="House Blend">House Blend</a>, <a
							href="beverages.html#mocha" title="Mocha Cafe Latte">Mocha
							Cafe Latte</a>, <a href="beverages.html#cappuccino"
							title="Cappuccino">Cappuccino</a>, and a favorite of our
						customers, <a href="beverages.html#chai" title="Chai Tea">Chai
							Tea</a>.
					</p>
				</article>
				<p>
					We also offer a variety of coffee beans, whole or ground, for you
					to take home with you. Order your coffee today using our online <a
						href="form.html" title="The Bean Machine">Bean Machine</a>, and
					take the Starbuzz Coffee experience home.
				</p>
			</section>

			<aside>
				<p class="beanheading">
					<img src="../../dam/somallg/images/bag.gif" alt="Bean Machine bag">
					<br> ORDER ONLINE with the <a href="form.html">BEAN
						MACHINE</a> <br> <span class="slogan"> FAST <br>
						FRESH <br> TO YOUR DOOR <br>
					</span>
				</p>
				<p>Why wait? You can order all our fine coffees right from the
					Internet with our new, automated Bean Machine. How does it work?
					Just click on the Bean Machine link, enter your order, and behind
					the scenes, your coffee is roasted, ground (if you want), packaged,
					and shipped to your door.</p>
			</aside>
		</div>
	</div>

	<footer>
		&copy; 2012, Starbuzz Coffee <br> All trademarks and registered
		trademarks appearing on this site are the property of their respective
		owners.
	</footer>
</body>