<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf" %>
<main>
    <section class="main">
        <div class="container-fluid">
            <div class="row">

                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="text-center"><strong>${requestScope.project.title}</strong></h2>
                            <h4 class="text-center">by <strong>Author (First name, Last name)</strong></h4>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="embed-responsive embed-responsive-16by9">
                                        <iframe class="embed-responsive-item" src=""></iframe>
                                    </div>
                                </div>
                                <div class="col-md-4 text-left">
                                    <h1><strong>${requestScope.countBackers}</strong></h1>
                                    <strong>backers</strong>
                                    <h1><strong>$${requestScope.total}</strong></h1>
                                    <strong>pledged of $${requestScope.project.total} goal</strong>
                                    <h1><strong>${requestScope.project.getNumberOfDaysToEnd()}</strong></h1>
                                    <strong>days to go</strong>
                                    <p class="button-back-remaind">
                                        <button type="button" class="btn btn-success btn-lg">Back This Project</button>
                                        <button type="button" class="btn btn-link btn-lg">Remind me</button>
                                    </p>
                                    <p class="text-muted">This project will be funded on Wed, Jan 27 2016 10:00 PM +02:00.</p>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-8 bottom-info">
                                    <div class="my-glyphicon">
                                        <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span><strong class="map-and-ganre">Krakow, Poland</strong> 
                                        <span class="glyphicon glyphicon-tag" aria-hidden="true"></span><strong class="map-and-ganre">Tabletop Games</strong>
                                    </div>
                                    <p class="short-info-project">${requestScope.project.description}</p>
                                    <div class="share-project">
                                        <span class="label label-default label-share">Share:</span>
                                        <!-- / Twitter ------------------------------- -->
                                        <a class="btn btn-default btn-sm btn-share" href="https://twitter.com/intent/tweet?text=Check%20out%20EMPIRES%20GALACTIC%20REBELLION%21%20A%20board%20game%20homage%20to%20Star%20Wars%20by%20Gryphon%20and%20Eagle%20Games%20on%20%40Kickstarter&amp;url=http%3A%2F%2Fkck.st%2F1Np2mPe" role="button">
                                            <img class="pull-left icon-share" src="resource/image/twitter.svg" alt="twitter"/>
                                            <b class="pull-left">Tweet</b>
                                        </a>
                                        <!-- / Facebook ------------------------------- -->
                                        <a class="btn btn-default btn-sm btn-share" data-facebook-shares-url="/projects/167427101/empires-galactic-rebellion-a-board-game-homage-to/facebook_share_count" href="https://www.kickstarter.com/projects/167427101/empires-galactic-rebellion-a-board-game-homage-to?ref=project_share">
                                            <img class="pull-left icon-share" src="resource/image/facebook.svg" alt="facebook"/>
                                            <b class="pull-left">Share</b>
                                        </a>
                                        <!-- / Vkontalte ------------------------------- -->
                                        <a class="btn btn-default btn-sm btn-share" data-facebook-shares-url="/projects/167427101/empires-galactic-rebellion-a-board-game-homage-to/facebook_share_count" href="https://www.kickstarter.com/projects/167427101/empires-galactic-rebellion-a-board-game-homage-to?ref=project_share">
                                            <img class="pull-left icon-share" src="resource/image/vk.svg" alt="vkontakte"/>
                                            <b class="pull-left">Share</b>
                                        </a>
                                        <!-- / Embed ------------------------------- -->
                                        <a class="btn btn-default btn-sm btn-share" data-modal-title="Embed a widget on your site" data-tracker-name="Embed" href="/projects/167427101/empires-galactic-rebellion-a-board-game-homage-to/widget">
                                            <img class="pull-left icon-share" src="resource/image/embed-close.svg" alt="embed-close"/>
                                            <b class="pull-left">Embed</b>
                                        </a>
                                        <!-- / Pinterest  ------------------------------- -->
                                        <button class="btn btn-default btn-sm btn-share">
                                            <img class="pull-left icon-share" src="resource/image/pin.svg" alt="pinterest"/>
                                            <b class="pull-left">Pin</b>
                                        </button>
                                        <!-- / Tumblr ------------------------------- -->

                                        <a class="btn btn-default btn-sm btn-share" href="https://www.tumblr.com/share/video?embed=https%3A%2F%2Fwww.kickstarter.com%2Fprojects%2F167427101%2Fempires-galactic-rebellion-a-board-game-homage-to&amp;caption=EMPIRES%20GALACTIC%20REBELLION%21%20A%20board%20game%20homage%20to%20Star%20Wars+-+Fight%20for%20Galactic%20Control%20as%20a%20Rebel%20Leader%20and%20Mobilize%20your%20Faction%20to%20Defeat%20the%20Empire%21+-+http%3A%2F%2Fkck.st%2F1Np2n5u" rel="nofollow">
                                            <img class="pull-left icon-share" src="resource/image/tumblr.svg" alt="tumblr"/>
                                            <b class="pull-left">Post</b>
                                        </a>
                                        <!-- / Curated page projects ---------------- -->
                                        <div class="curate inline-block">
                                        </div>

                                    </div>
                                </div>
                                <div class="col-md-4 text-left">
                                    <div class="border-top author-info-panel">
                                        <div class="row">
                                            <div class="col-lg-8 col-xs-8">
                                                <a class="link-author" data-toggle="modal" data-target="#myModal">
                                                    <h5><strong>First Name Last Name</strong></h5>
                                                </a>
                                            </div>
                                            <div class="col-lg-4 col-xs-4 ">
                                                <a class="link-author" data-toggle="modal" data-target="#myModal">
                                                    <img class="img-circle img-responsive" src="resource/image/100_0602.JPG" alt="Photo author project">
                                                </a>
                                                <!-- Modal -->
                                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                                                <h4 class="modal-title" id="myModalLabel">About the creator</h4>
                                                            </div>
                                                            <div class="modal-body">
                                                                In 1986 I became the Art Director of White Wolf Magazine, responsible for the visuals that are such an integral part of our White Wolf books. Years later, oversight of the writing and game design was added when I became Creative Director. I helped to evolve White Wolf into the digital age of publishing, and now am running Onyx Path Publishing to bring tabletop RPGs (our licensed WW games as well as our own) into this new era. Along the way, I created just about every symbol, alphabet, or...
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <h3>
                        About this project
                    </h3> 
                    <p>
                        ${requestScope.project.historyProject}
                    </p>
                </div>
                <div class="col-md-4">
                    <h3>
                        Rewards
                    </h3>  
                    <div class="well">
                        <h5><strong>Pledge $1</strong></h5>
                        <p><small> <strong>count backers</strong></small></p>
                        <p>I just want to help the project.
                        </p>
                        <h4>
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1" aria-expanded="true" aria-controls="collapse1">
                                Select this reward
                            </a>
                        </h4>
                        <div id="collapse1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <form role="form" action="${pageContext.servletContext.contextPath}/payment.jsp">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Pledge amount</label>
                                    <strong> <input type="text" class="form-control" id="exampleInputEmail1" value="$1"></strong>
                                </div>
                                <button  type="submit" class="btn btn-success btn-block">
                                    <strong>Continue</strong>
                                </button>
                            </form>
                        </div>
                    </div>
                    <div class="well">
                        <h5><strong>Pledge $1 or more</strong></h5>
                        <p><small> <strong>count backers</strong></small></p>
                        <p>You or your character's name will be listed on the credits page as one of our supporters: the army of the night.
                        </p>
                        <strong>Estimated delivery:</strong>
                        <br>
                        Dec 2016
                        <h4>
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="true" aria-controls="collapseOne">
                                Select this reward
                            </a>
                        </h4>
                        <div id="collapse2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <form role="form" action="${pageContext.servletContext.contextPath}/payment.jsp">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Pledge amount</label>
                                    <strong> <input type="text" class="form-control" id="exampleInputEmail1" value="$1"></strong>
                                </div>
                                <button  type="submit" class="btn btn-success btn-block">
                                    <strong>Continue</strong>
                                </button>
                            </form>
                        </div>
                    </div>
                    <div class="well">
                        <h5><strong>Pledge $10 or more</strong></h5>
                        <p><small> <strong>count backers</strong></small></p>
                        <p>You or your character's name will be listed on the credits page as one of our supporters: the army of the night.
                        </p>
                        <strong>Estimated delivery:</strong>
                        <br>
                        Dec 2016
                        <h4>
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse3" aria-expanded="true" aria-controls="collapseOne">
                                Select this reward
                            </a>
                        </h4>
                        <div id="collapse3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <form role="form" action="${pageContext.servletContext.contextPath}/payment.jsp">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Pledge amount</label>
                                    <strong> <input type="text" class="form-control" id="exampleInputEmail1" value="$10"></strong>
                                </div>
                                <button  type="submit" class="btn btn-success btn-block">
                                    <strong>Continue</strong>
                                </button>
                            </form>
                        </div>
                    </div>
                    <div class="well">
                        <h5><strong>Pledge $40 or more</strong></h5>
                        <p><small> <strong>count backers</strong></small></p>
                        <p>You or your character's name will be listed on the credits page as one of our supporters: the army of the night.
                        </p>
                        <strong>Estimated delivery:</strong>
                        <br>
                        Dec 2016
                        <h4>
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse4" aria-expanded="true" aria-controls="collapseOne">
                                Select this reward
                            </a>
                        </h4>
                        <div id="collapse4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <form role="form"  action="${pageContext.servletContext.contextPath}/payment.jsp">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Pledge amount</label>
                                    <strong> <input type="text" class="form-control" id="exampleInputEmail1" value="$40"></strong>
                                </div>
                                <button  type="submit" class="btn btn-success btn-block">
                                    <strong>Continue</strong>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
    </section>
</main>
<%@include file="WEB-INF/jspf/footer.jspf" %>
